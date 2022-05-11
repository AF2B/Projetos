import Client from "../../core/Client";
import ClientRepository from "../../core/ClientRepository";
import firebase from "../config";

export default class CollectionClient implements ClientRepository {

    private convert = {
        toFirestore(client: Client) {
            return {
                name: client.Name,
                age: client.Age
            }
        },
        fromFirestore(snapshot: firebase.firestore.QueryDocumentSnapshot, options: firebase.firestore.SnapshotOptions) {
            const data = snapshot?.data(options)
            return new Client(data.name, data.age, snapshot.id)
        }
    }

    async save(client: Client): Promise<Client> {
        if (client?.Id) {
            await this.collection().doc(client.Id).set(client)
            return client
        }else{
            const docRef = await this.collection().add(client)
            const doc = await docRef.get()
            return doc.data()
        }
    }
    async delete(client: Client): Promise<void> {
        return this.collection().doc(client.Id).delete()
    }
    async readAll(): Promise<Client[]> {
        const query = await this.collection().get()
        return query.docs.map(doc => doc.data()) ?? []
    }

    private collection() {
        return firebase.firestore().collection("clients").withConverter(this.convert)
    }

}