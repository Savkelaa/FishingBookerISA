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
import FishingClassCardByInstructorContainer from "./Containers/FishingClassCardByInstructorContainer";
import CreateFishingClass from "./Containers/CreateFishingClassContainer";
import PredefAdminHomePageConatiner from "./Containers/PredefAdminHomePageContainer";
import CreateAdminContainer from "./Containers/CreateAdminContainer";
import ChangePasswordContainer from "./Containers/ChangePasswordContainer";
import ClientHomePageContainer from "./Containers/ClientHomePageContainer";
import ChangePasswordInstructorContainer from "./Containers/ChangePasswordInstructorContainer";
import CottageOwnerHomePageContainer from "./Containers/CottageOwnerHomePageContainer";
import BoatOwnerHomePageContainer from "./Containers/BoatOwnerHomePageContainer";

import AvailabilityPeriodContainer from "./Containers/AvailabilityPeriodContainer";
import CurrentReservationsContainer from "./Containers/CurrentReservationsContainer";
import CreateFishingClassReservationContainer from "./Containers/CreateFishingClassReservationContainer";
import FishingClassReservationHistoryContainer from "./Containers/FishingClassReservationHistoryContainer";
import FishingClassReservationHistoryByClientContainer from "./Containers/FishingClassReservationHistoryByClientContainer";
import FishingClassFutureReservationClientContainer from "./Containers/FishingClassFutureReservationClientContainer";
import RateRequestsContainer from "./Containers/RateRequestsContainer";
import ComplaintRequestsContainer from "./Containers/ComplaintRequestsContainer";
import ClientsByInstructorContainer from "./Containers/ClientsByInstructorContainer";
import InstructorCreateReportContainer from "./Containers/InstructorCreateReportContainer";
import ReportRequestsContainer from "./Containers/ReportRequestsContainer";
import DefinePointsContainer from "./Containers/DefinePointsContainer";
import CreateLoyaltyCategoryContainer from "./Containers/CreateLoyaltyCategoryContainer";

import CottageContainer from "./Containers/CottageContainer";
import CottagesByOwnerContainer from "./Containers/CottagesByOwnerContainer";
import CreateCottageContainer from "./Containers/CreateCottageContainer";
import ChangePasswordCottageOwnerContainer from "./Containers/ChangePasswordCottageOwnerContainer";
import CottageReservationHistoryContainer from "./Containers/CottageReservationHistoryContainer";
import CreateCottageActionContainer from "./Containers/CreateCottageActionContainer";
import CottageUpcomingReservationsContainer from "./Containers/CottageUpcomingReservationsContainer";
import CottageCurrentReservationsContainer from "./Containers/CottageCurrentReservations";
import ClientsByCottageOwnerContainer from "./Containers/ClientsByCottageOwner";
import CottageOwnerCreateReportContainer from "./Containers/CottageOwnerCreateReportContainer";
import CottageAvailabilityPeriodContainer from "./Containers/CottageAvailabilityPeriodContainer";
import CreateCottageReservationContainer from "./Containers/CreateCottageReservationContainer";


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
          <Route path="/fishingClassByInstructor">
            <FishingClassCardByInstructorContainer></FishingClassCardByInstructorContainer>
          </Route>
          <Route path="/login">
            <LoginContainer></LoginContainer>
          </Route>
          <Route path="/createQuickReservation/:id">
            <CreateFishingClassQuickReservationContainer></CreateFishingClassQuickReservationContainer>
          </Route>
          <Route path="/createReservation/:id">
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
          <Route path="/createFishingClass">
            <CreateFishingClass></CreateFishingClass>
          </Route>
          <Route path="/cottageOwnerHomePage">
            <CottageOwnerHomePageContainer></CottageOwnerHomePageContainer>
          </Route>
          <Route path="/boatOwnerHomePage">
            <BoatOwnerHomePageContainer></BoatOwnerHomePageContainer>
          </Route>
          <Route path="/predefAdminHomePage">
            <PredefAdminHomePageConatiner></PredefAdminHomePageConatiner>
          </Route>
          <Route path="/createAdmin">
            <CreateAdminContainer></CreateAdminContainer>
          </Route>
          <Route path="/changePassword">
            <ChangePasswordContainer></ChangePasswordContainer>
          </Route>
          <Route path="/changePasswordInstructor">
            <ChangePasswordInstructorContainer></ChangePasswordInstructorContainer>
          </Route>
          <Route path="/clientHomePage">
            <ClientHomePageContainer></ClientHomePageContainer>
          </Route>
          <Route path="/availabilityPeriod">
            <AvailabilityPeriodContainer></AvailabilityPeriodContainer>
          </Route>
          <Route path="/currentReservations">
            <CurrentReservationsContainer></CurrentReservationsContainer>
          </Route>
          <Route path="/fishingClassReservationHistory">
            <FishingClassReservationHistoryContainer></FishingClassReservationHistoryContainer>
          </Route>
          <Route path="/fishingClassReservationHistoryByClient">
            <FishingClassReservationHistoryByClientContainer></FishingClassReservationHistoryByClientContainer>
          </Route>
          <Route path="/fishingClassFutureReservationByClient">
            <FishingClassFutureReservationClientContainer></FishingClassFutureReservationClientContainer>
          </Route>
          <Route path="/rateRequests">
            <RateRequestsContainer></RateRequestsContainer>
          </Route>
          <Route path="/complaintRequests">
            <ComplaintRequestsContainer></ComplaintRequestsContainer>
          </Route>
          <Route path="/clientsByInstructor">
            <ClientsByInstructorContainer></ClientsByInstructorContainer>
          </Route>
          <Route path="/instructorCreateReport/:id">
            <InstructorCreateReportContainer></InstructorCreateReportContainer>
          </Route>
          <Route path="/reportRequests">
            <ReportRequestsContainer></ReportRequestsContainer>
          </Route>

          <Route path="/definePoints">
            <DefinePointsContainer></DefinePointsContainer>
          </Route>
          <Route path="/createLoyaltyCategory">
            <CreateLoyaltyCategoryContainer></CreateLoyaltyCategoryContainer>
          </Route>

          <Route path="/cottage/:id">
            <CottageContainer></CottageContainer>
          </Route>

          <Route path="/cottagesByOwner">
            <CottagesByOwnerContainer></CottagesByOwnerContainer>
          </Route>

          <Route path="/createCottage">
            <CreateCottageContainer></CreateCottageContainer>
          </Route>

          <Route path ="/changePasswordCottageOwner">
            <ChangePasswordCottageOwnerContainer></ChangePasswordCottageOwnerContainer>
          </Route>

          <Route path = "/cottageReservationHistory">
            <CottageReservationHistoryContainer></CottageReservationHistoryContainer>
          </Route>

          <Route path = "/createCottageQuickReservationAction/:id">
            <CreateCottageActionContainer></CreateCottageActionContainer>
          </Route>

          <Route path = "/cottageUpcomingReservation">
            <CottageUpcomingReservationsContainer></CottageUpcomingReservationsContainer>
          </Route>

          <Route path = "/cottageCurrentReservation">
            <CottageCurrentReservationsContainer></CottageCurrentReservationsContainer>
          </Route>

          <Route path = "/clientsByCottageOwner">
            <ClientsByCottageOwnerContainer></ClientsByCottageOwnerContainer>
          </Route>
          
          <Route path = "/cottageOwnerCreateReport/:id">
            <CottageOwnerCreateReportContainer></CottageOwnerCreateReportContainer>
          </Route>

          <Route path = "/cottageAvailabilityPeriod/:id">
            <CottageAvailabilityPeriodContainer></CottageAvailabilityPeriodContainer>
          </Route>

          <Route path = "/createCottageReservation/:id">
            <CreateCottageReservationContainer></CreateCottageReservationContainer>
          </Route>

        </Switch>
      </Router>
    </div>
  );
}

export default App;
