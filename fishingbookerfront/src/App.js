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
import CreateFishingClassReservationContainer from "./Containers/CreateFishingClassReservationContainer";
import InstructorHomePageContainer from "./Containers/InstructorHomePageContainer";
import LoginContainer from "./Containers/LoginContainer";
import UserRegistrationContainer from "./Containers/UserRegistrationContainer";
import AdminHomePageContainer from "./Containers/AdminHomePageContainer";
import RequestsContainer from "./Containers/RequestsContainer";
import AllInstructorsContainer from "./Containers/AllInstructorsContainer";
import AllBoatOwnersContainer from "./Containers/AllBoatOwnersContainer";
import AllCottageOwnersContainer from "./Containers/AllCottageOwnersContainer";
import AllCottagesContainer from "./Containers/AllCottagesContainer";
import AllBoatsContainer from "./Containers/AllBoatsContainer";
import DeleteRequestsContainer from "./Containers/DeleteRequestsContainer";
import FishingClassCardByInstructor from "./Components/Common/FishingClassCardByInstructor";

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
          <Route
            path="/fishingClassesByInstructor"
            component={FishingClassCardByInstructor}
          >
            <FishingClassCardByInstructor></FishingClassCardByInstructor>
          </Route>
          <Route path="/login">
            <LoginContainer></LoginContainer>
          </Route>
          <Route path="/createQuickReservation">
            <CreateFishingClassReservationContainer></CreateFishingClassReservationContainer>
          </Route>
          <Route path="/userRegistration">
            <UserRegistrationContainer></UserRegistrationContainer>
          </Route>
          <Route path="/instructorHomePage">
            <InstructorHomePageContainer></InstructorHomePageContainer>
          </Route>
          <Route path="/adminHomePage">
            <AdminHomePageContainer></AdminHomePageContainer>
          </Route>
          <Route path="/requests">
            <RequestsContainer></RequestsContainer>
          </Route>
          <Route path="/deleteRequests">
            <DeleteRequestsContainer></DeleteRequestsContainer>
          </Route>
          <Route path="/allInstructors">
            <AllInstructorsContainer></AllInstructorsContainer>
          </Route>
          <Route path="/allCottageOwners">
            <AllCottageOwnersContainer></AllCottageOwnersContainer>
          </Route>
          <Route path="/allBoatOwners">
            <AllBoatOwnersContainer></AllBoatOwnersContainer>
          </Route>
          <Route path="/allBoats">
            <AllBoatsContainer></AllBoatsContainer>
          </Route>
          <Route path="/allCottages">
            <AllCottagesContainer></AllCottagesContainer>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
