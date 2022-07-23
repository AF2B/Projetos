import './App.css';
import AlteraEstado from './AlteraEstado';
import Carro from './Carro';
import ButtonAltera from './ButtonAltera';
import Contador from './Contador';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <AlteraEstado>
          <Carro name="Mustang"></Carro>
        </AlteraEstado>
        <ButtonAltera name="André"></ButtonAltera>
        <hr />
        <Contador />
      </header>
    </div>
  );
}

export default App;
