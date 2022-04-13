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
import CreateFishingClassQuickReservationContainer from "./Containers/CreateFishingClassQuickReservationContainer";
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
import FishingClassCardByInstructorContainer from "./Containers/FishingClassCardByInstructorContainer";
import CreateFishingClass from "./Containers/CreateFishingClassContainer";
import ClientHomePageContainer from "./Containers/ClientHomePageContainer";

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
          <Route path="/fishingClassesByInstructor">
            <FishingClassCardByInstructorContainer></FishingClassCardByInstructorContainer>
          </Route>
          <Route path="/login">
            <LoginContainer></LoginContainer>
          </Route>
          <Route path="/createQuickReservation/:id">
            <CreateFishingClassQuickReservationContainer></CreateFishingClassQuickReservationContainer>
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
          <Route path="/createFishingClass">
            <CreateFishingClass></CreateFishingClass>
          </Route>
        </Switch>
        <Route path="/clientHomePage">
            <ClientHomePageContainer></ClientHomePageContainer>
          </Route>
      </Router>
    </div>
  );
}

export default App;
