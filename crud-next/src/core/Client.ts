export default class Client {
    private id: string;
    private name: string;
    private age: number;

    constructor(name: string, age: number, id: string = null) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    static clientNull() {
        return new Client('', 0)
    }

    get Id() {
        return this.id;
    }

    get Name() {
        return this.name;
    }

    get Age() {
        return this.age;
    }
}