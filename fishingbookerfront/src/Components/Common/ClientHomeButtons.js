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
        <Link to="fishingClassReservationHistoryByClient">
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
        </Link>


        <Link to="/boatCurrentReservation2">
          <button className="btn btn-primary profile-button" type="button">
            QuickCottageReservation
          </button>
        </Link>
       

        <button className="btn btn-primary profile-button" type="button">
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
        </button>
      </div>
    </div>
  );
}
