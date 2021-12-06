import logo from "./logo.svg";
import "./App.css";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";
import FishingClassContainer from "./Containers/FishingClassContainer";

function App() {
  return (
    <div className="container">
      <Router>
        <Switch>
          <Route path="/fishing">
            <FishingClassContainer></FishingClassContainer>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
