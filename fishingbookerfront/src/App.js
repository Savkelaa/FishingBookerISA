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
import CalendarContainer from "./Containers/CalendarContainer";
import CalendarCottageOwnerContainer from "./Containers/CalendarCottageOwnerContainer";
import CalendarBoatOwnerContainer from "./Containers/CalendarBoatOwnerContainer";
import ChangePasswordBoatOwnerContainer from "./Containers/ChangePasswordBoatOwnerContainer"
import BoatContainer from "./Containers/BoatContainer";
import CreateBoatContainer from "./Containers/CreateBoatContainer";
import BoatsByOwnerContainer from "./Containers/BoatsByOwnerContainer";
import BoatUpcomingReservationsContainer from "./Containers/BoatUpcomingReservationsContainer";
import BoatReservationHistoryContainer from "./Containers/BoatReservationHistoryContainer";
import BoatCurrentReservationsContainer from "./Containers/BoatCurrentReservations";
import CreateBoatReservationContainer from "./Containers/CreateBoatReservationContainer";
import CreateBoatActionContainer from "./Containers/CreateBoatActionContainer";
import BoatAvailabilityPeriodContainer from "./Containers/BoatAvailabilityPeriodContainer";
import ClientsByBoatOwnerContainer from "./Containers/ClientsByBoatOwnerContainer";
import BoatOwnerCreateReport from "./Components/Common/BoatOwnerCreateReport";
import BoatOwnerCreateReportContainer from "./Containers/BoatOwnerCreateReportContainer";
import CottageReservationHistoryByClientContainer from  "./Containers/CottageReservationHistoryByClientContainer"
import BoatReservationHistoryClientContainer from "./Containers/BoatReservationHistoryClientContainer"
import BoatReservationClientAllContainer from "./Containers/BoatReservationClientAllContainer"
import CottageReservationClientAllContainer from "./Containers/CottageReservationClientAllContainer"
import FishingClassReservationClientAllContainer from "./Containers/FishingClassReservationClientAllContainer"
import BoatCurrentReservationsContainer2 from "./Containers/BoatCurrentReservations2"
import CreateBoatReservationContainer2 from "./Containers/CreateBoatReservationContainer2";
import CottageCurrentReservationsContainer2 from "./Containers/CottageCurrentReservation2";
import CreateCottageActionContainer2 from "./Containers/CreateCottageActionContainer2";
import CreateCottageReservationContainer2 from "./Containers/CreateCottageReservationContainer2";
import FishingClassReservationHistoryContainer2 from "./Containers/FishingClassReservationHistoryContainer2";
import CreateFishingClassReservationContainer2 from "./Containers/CreateFishingClassReservationContainer2";
import QuickBoatFuture from "./Containers/BoatQuickFuture";
import QuickCottageFuture from "./Containers/CottageQuickFuture";
import QuickFishingClassFuture from "./Containers/FishingClassCancelContainer";
import SelectDatesOrdinaryCottage from "./Containers/CreateOrdinaryCottageReservationContainer";
import CreateOrdinaryCottage from "./Containers/OrdinaryCottagesContainer";
import OrdinaryCottageReservationAll from "./Containers/CottageOrdinaryReservationsAllContainer";
import SelectDatesOrdinaryBoat from "./Containers/CreateOrdinaryBoatReservationContainer";
import CreateOrdinaryBoat from "./Containers/OrdinaryBoatsContainer";
import OrdinaryBoatReservationAll from "./Containers/BoatOrdinaryReservationsAllContainer";
import SelectDatesOrdinaryFishingClass from "./Containers/CreateOrdinaryFishingClassReservationContainer";
import CreateOrdinaryFishingClass from "./Containers/OrdinaryFishingClassContainer";
import OrdinaryFishingClassReservationAll from "./Containers/FishingClassOrdinaryReservationsAllContainer";
import OrdinaryBoatFuture from "./Containers/BoatOrdinaryFuture"
import OrdinaryCottageFuture from "./Containers/CottageOrdinaryFuture"
import OrdinaryFishingClassFuture from "./Containers/FishingClassOrdinaryCancelContainer"
import CottageOrdinaryReservationHistoryContainer from "./Containers/CottageOrdinaryReservationHistoryContainer";
import BoatOrdinaryReservationHistoryContainer from "./Containers/BoatOrdinaryReservationHistoryContainer";
import FishingClassOrdinaryHistoryContainer from "./Containers/FishingClassOrdinaryReservationHistoryContainer"




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
         
          <Route path="/fishingClassReservationHistoryByClient">
            <FishingClassReservationHistoryByClientContainer></FishingClassReservationHistoryByClientContainer>
          </Route>
          <Route path="/fishingClassReservationClientAll">
            <FishingClassReservationClientAllContainer></FishingClassReservationClientAllContainer>
          </Route>
          <Route path="/cottageReservationHistoryByClient">
            <CottageReservationHistoryByClientContainer></CottageReservationHistoryByClientContainer>
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

        

          <Route path="/changePasswordCottageOwner">
            <ChangePasswordCottageOwnerContainer></ChangePasswordCottageOwnerContainer>
          </Route>

          <Route path="/cottageReservationHistory">
            <CottageReservationHistoryContainer></CottageReservationHistoryContainer>
          </Route>

          <Route path="/cottageReservationHistoryClient">
            <CottageReservationHistoryByClientContainer></CottageReservationHistoryByClientContainer>
          </Route>

          <Route path="/cottageReservationClientAll">
            <CottageReservationClientAllContainer></CottageReservationClientAllContainer>
          </Route>

         
          <Route path="/cottageUpcomingReservation">
            <CottageUpcomingReservationsContainer></CottageUpcomingReservationsContainer>
          </Route>

         

          <Route path="/clientsByCottageOwner">
            <ClientsByCottageOwnerContainer></ClientsByCottageOwnerContainer>
          </Route>

          <Route path="/cottageOwnerCreateReport/:id">
            <CottageOwnerCreateReportContainer></CottageOwnerCreateReportContainer>
          </Route>

          <Route path="/cottageAvailabilityPeriod/:id">
            <CottageAvailabilityPeriodContainer></CottageAvailabilityPeriodContainer>
          </Route>

         

      

          <Route path="/calendar">
            <CalendarContainer></CalendarContainer>
          </Route>

          <Route path="/calendarCottageOwner">
            <CalendarCottageOwnerContainer></CalendarCottageOwnerContainer>
          </Route>

          <Route path="/calendarBoatOwner">
            <CalendarBoatOwnerContainer></CalendarBoatOwnerContainer>
          </Route>

          <Route path="/changePasswordBoatOwner">
            <ChangePasswordBoatOwnerContainer></ChangePasswordBoatOwnerContainer>
          </Route>

          <Route path = "/boat/:id">
            <BoatContainer></BoatContainer>
          </Route>

          <Route path = "/createBoat">
            <CreateBoatContainer></CreateBoatContainer>
          </Route>

          <Route path = "/boatsByOwner">
            <BoatsByOwnerContainer></BoatsByOwnerContainer>
          </Route>

          <Route path = "/boatUpcomingReservation">
            <BoatUpcomingReservationsContainer></BoatUpcomingReservationsContainer>
          </Route>

          <Route path = "/boatReservationHistory">
            <BoatReservationHistoryContainer></BoatReservationHistoryContainer>
          </Route>

          <Route path = "/boatReservationHistoryClient">
            <BoatReservationHistoryClientContainer></BoatReservationHistoryClientContainer>
          </Route>

          <Route path = "/boatReservationClientAll">
            <BoatReservationClientAllContainer></BoatReservationClientAllContainer>
          </Route>

        

       

          <Route path = "/createBoatQuickReservationAction/:id">
            <CreateBoatActionContainer></CreateBoatActionContainer>
          </Route>

          <Route path = "/boatAvailabilityPeriod/:id">
            <BoatAvailabilityPeriodContainer></BoatAvailabilityPeriodContainer>
          </Route>

          <Route path = "/clientsByBoatOwner">
            <ClientsByBoatOwnerContainer></ClientsByBoatOwnerContainer>
          </Route>

          <Route path = "/boatOwnerCreateReport/:id">
            <BoatOwnerCreateReportContainer></BoatOwnerCreateReportContainer>
          </Route>


          //------------------------------------------------------OVO SAD REMINO ZA QUICK Reservation
          <Route path = "/boatCurrentReservation">
            <BoatCurrentReservationsContainer></BoatCurrentReservationsContainer>
          </Route>

          <Route path = "/boatCurrentReservation2">
            <BoatCurrentReservationsContainer2></BoatCurrentReservationsContainer2>
          </Route>

//ne treba dupla za ovo
          <Route path = "/createBoatReservation/:id">
            <CreateBoatReservationContainer></CreateBoatReservationContainer>
          </Route>

          <Route path = "/createBoatReservation2/:id">
            <CreateBoatReservationContainer2></CreateBoatReservationContainer2>
          </Route>
//--------- SAD COTTAGE
          
          <Route path="/cottageCurrentReservation">
            <CottageCurrentReservationsContainer></CottageCurrentReservationsContainer>
          </Route>

          <Route path="/createCottageQuickReservationAction/:id">
            <CreateCottageActionContainer></CreateCottageActionContainer>
          </Route>


          <Route path="/cottageCurrentReservation2">
            <CottageCurrentReservationsContainer2></CottageCurrentReservationsContainer2>
          </Route>

          <Route path="/createCottageQuickReservationAction2/:id">
            <CreateCottageActionContainer2></CreateCottageActionContainer2>
          </Route>

          <Route path="/createCottageReservation/:id">
            <CreateCottageReservationContainer></CreateCottageReservationContainer>
          </Route>

          <Route path="/createCottageReservation2/:id">
            <CreateCottageReservationContainer2></CreateCottageReservationContainer2>
          </Route>
//-----------Fishing className

          <Route path="/createReservation/:id">
            <CreateFishingClassReservationContainer></CreateFishingClassReservationContainer>
          </Route>

          <Route path="/fishingClassReservationHistory">
            <FishingClassReservationHistoryContainer></FishingClassReservationHistoryContainer>
          </Route>

          <Route path="/createReservation2/:id">
            <CreateFishingClassReservationContainer2></CreateFishingClassReservationContainer2>
          </Route>

          <Route path="/fishingClassReservationClientCreate2">
            <FishingClassReservationHistoryContainer2></FishingClassReservationHistoryContainer2>
          </Route>

//-----------------------future

          <Route path="/boatQuickReservationsFuture">
            <QuickBoatFuture></QuickBoatFuture>
          </Route>

          <Route path="/boatOrdinaryReservationsFuture">
            <OrdinaryBoatFuture></OrdinaryBoatFuture>
          </Route>

          <Route path="/cottageQuickReservationsFuture">
            <QuickCottageFuture></QuickCottageFuture>
          </Route>

          <Route path="/cottageOrdinaryReservationsFuture">
            <OrdinaryCottageFuture></OrdinaryCottageFuture>
          </Route>

          <Route path="/fishingClassQuickReservationsFuture">
            <QuickFishingClassFuture></QuickFishingClassFuture>
          </Route>

          <Route path="/fishingClassOrdinaryReservationsFuture">
            <OrdinaryFishingClassFuture></OrdinaryFishingClassFuture>
          </Route>

//----------obicne REZ

          <Route path="/createCottage">
            <CreateCottageContainer></CreateCottageContainer>
          </Route>
//--------cottage
          <Route path="/selectDatesOrdinaryCottage">
            <SelectDatesOrdinaryCottage></SelectDatesOrdinaryCottage>
          </Route>

          <Route path="/createOrdinaryCottage">
            <CreateOrdinaryCottage></CreateOrdinaryCottage>
          </Route>

          <Route path="/OrdinaryCottageReservationAll">
            <OrdinaryCottageReservationAll></OrdinaryCottageReservationAll>
          </Route>

//-----boat
          <Route path="/selectDatesOrdinaryBoat">
            <SelectDatesOrdinaryBoat></SelectDatesOrdinaryBoat>
          </Route>

          <Route path="/createOrdinaryBoat">
            <CreateOrdinaryBoat></CreateOrdinaryBoat>
          </Route>

          <Route path="/OrdinaryBoatReservationAll">
            <OrdinaryBoatReservationAll></OrdinaryBoatReservationAll>
          </Route>

//---------fishingclass

          <Route path="/selectDatesOrdinaryFishingClass">
            <SelectDatesOrdinaryFishingClass></SelectDatesOrdinaryFishingClass>
          </Route>

          <Route path="/createOrdinaryFishingClass">
            <CreateOrdinaryFishingClass></CreateOrdinaryFishingClass>
          </Route>

          <Route path="/OrdinaryFishingClassReservationAll">
            <OrdinaryFishingClassReservationAll></OrdinaryFishingClassReservationAll>
          </Route>
 //----------history         

          <Route path="/cottageOrdinaryReservationHistory">
            <CottageOrdinaryReservationHistoryContainer></CottageOrdinaryReservationHistoryContainer>
          </Route>


   
          <Route path="/boatOrdinaryReservationHistory">
            <BoatOrdinaryReservationHistoryContainer></BoatOrdinaryReservationHistoryContainer>
          </Route>

          <Route path="/fishingClassOrdinaryReservationHistory">
            <FishingClassOrdinaryHistoryContainer></FishingClassOrdinaryHistoryContainer>
          </Route>

        </Switch>
      </Router>
    </div>
  );
}

export default App;
