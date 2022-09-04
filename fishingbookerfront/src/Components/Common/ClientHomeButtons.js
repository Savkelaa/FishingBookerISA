import React from "react";
import { Link } from "react-router-dom";

export default function ClientHomeButtons() {
  // const newTo = {
  //   pathname: "/fishingClassesByInstructor",
  //  param1: { fishingClassesByInstructor },
  // };

  // console.log("troeolo", fishingClassesByInstructor);

  return (
    <div className="col-md-4">
      <div className="p-3 py-5">
        <div className="d-flex justify-content-between align-items-center experience"></div>
        {/* <Link to="fishingClassReservationHistoryByClient">
          <button className="btn btn-primary profile-button" type="button">
            History of Fishing Class reservations
          </button>
        </Link>
        <Link to="fishingClassReservationClientAll">
          <button className="btn btn-primary profile-button" type="button">
            Allf Fishing Class reservations
          </button>
        </Link>
        <Link to="cottageReservationHistoryByClient">
          <button className="btn btn-primary profile-button" type="button">
            CottageReservationHistory
          </button>
        </Link>
        <Link to="cottageReservationClientAll">
          <button className="btn btn-primary profile-button" type="button">
            AllCottageReservation
          </button>
        </Link>
        <Link to="fishingClassFutureReservationByClient">
          <button className="btn btn-primary profile-button" type="button">
            Future reservations
          </button>
        </Link>
        <Link to="boatReservationClientAll">
          <button className="btn btn-primary profile-button" type="button">
           All Boat reservations
          </button>
        </Link>
        <Link to="boatReservationHistoryClient">
          <button className="btn btn-primary profile-button" type="button">
            History Boat reservations
          </button>
        </Link> */}


        <Link to="/boatCurrentReservation2">
          <button className="btn btn-primary profile-button" type="button">
            Create QuickBoatReservation
          </button>
        </Link>

        <Link to="/cottageCurrentReservation2">
          <button className="btn btn-primary profile-button" type="button">
            Create QuickCottageReservation
          </button>
        </Link>

        <Link to="/fishingClassReservationClientCreate2">
          <button className="btn btn-primary profile-button" type="button">
            Create FishingClassQuickReservation
          </button>
        </Link>
       

        {/* <button className="btn btn-primary profile-button" type="button">
          Create reservation
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Create quick reservation
        </button>

        <button className="btn btn-primary profile-button" type="button">
          Cancel reservation
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Make a complaint
        </button> */}
{/* 
        <Link to="/boatQuickReservationsFuture">
          <button className="btn btn-primary profile-button" type="button">
            Cancel BoatQuickReservation
          </button>
        </Link>

        <Link to="/cottageQuickReservationsFuture">
          <button className="btn btn-primary profile-button" type="button">
            Cancel CottageQuickReservation
          </button>
        </Link>

        <Link to="/fishingClassQuickReservationsFuture">
          <button className="btn btn-primary profile-button" type="button">
            Cancel FishingClassQuickReservation
          </button>
        </Link> */}

        <Link to="/selectDatesOrdinaryCottage">
          <button className="btn btn-primary profile-button" type="button">
            Create CottageReservation ORDINARY
          </button>
        </Link>

        {/* <Link to="/OrdinaryCottageReservationAll">
          <button className="btn btn-primary profile-button" type="button">
            All Ordinary Cottage Reservations
          </button>
        </Link> */}

        <Link to="/selectDatesOrdinaryBoat">
          <button className="btn btn-primary profile-button" type="button">
            Create BoatReservation ORDINARY
          </button>
        </Link>

        {/* <Link to="/OrdinaryFishingClassReservationAll">
          <button className="btn btn-primary profile-button" type="button">
            All Ordinary FishingClass Reservations
          </button>
        </Link> */}


        <Link to="/selectDatesOrdinaryFishingClass">
          <button className="btn btn-primary profile-button" type="button">
            Create FishingClassReservation ORDINARY
          </button>
        </Link>


        <Link to="/follow">
          <button className="btn btn-primary profile-button" type="button">
            Follow
          </button>
        </Link>

        <Link to="/followings">
          <button className="btn btn-primary profile-button" type="button">
            Followings
          </button>
        </Link>
      

        {/* <Link to="/OrdinaryFishingClassReservationAll">
          <button className="btn btn-primary profile-button" type="button">
            All Ordinary FishingClass Reservations
          </button>
        </Link>

        <Link to="/boatOrdinaryReservationsFuture">
          <button className="btn btn-primary profile-button" type="button">
            Future BoatReservation ORDINARY
          </button>
        </Link>

        <Link to="/cottageOrdinaryReservationsFuture">
          <button className="btn btn-primary profile-button" type="button">
            Future Ordinary Cottage Reservations
          </button>
        </Link>
        
        <Link to="/fishingClassOrdinaryReservationsFuture">
          <button className="btn btn-primary profile-button" type="button">
            Future Ordinary FishingClass Reservations
          </button>
        </Link>
        
        <Link to="/cottageOrdinaryReservationHistory">
          <button className="btn btn-primary profile-button" type="button">
            History Ordinary Cottage Reservations
          </button>
        </Link>

        <Link to="/boatOrdinaryReservationHistory">
          <button className="btn btn-primary profile-button" type="button">
            History Ordinary Boat Reservations
          </button>
        </Link>

        <Link to="/fishingClassOrdinaryReservationHistory">
          <button className="btn btn-primary profile-button" type="button">
            History Ordinary Fishing Class Reservations
          </button>
        </Link>
        */}
        
      
      </div>
    </div>
  );
}
