import logo from "./logo.svg";
import "./App.css";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";
import FishingClassesContainer from "./Containers/FishingClassesContainer";
import FishingClassContainer from "./Containers/FishingClassContainer";

function App() {
  return (
    <div className="container">
      <Router>
        <Switch>
          <Route path="/fishing/:id">
            <FishingClassContainer></FishingClassContainer>
          </Route>
          <Route path="/fishingClasses">
            <FishingClassesContainer></FishingClassesContainer>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
