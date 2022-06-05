import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import BoatQuickReservationServices from "../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import CreateBoatReservation from "../Components/Common/CreateBoatReservation";

export default function CreateBoatReservationContainer() {
  const [reservation, setReservation] = useState();

  function createBoatReservation(reservation) {
    BoatQuickReservationServices.createBoatReservation(
      reservation
    )
      .then((data) => {
        if (data.status === 204) setReservation();
        else {
          setReservation(data.data);
          alert("sucessfuly added a reservation");
        }
      })
      .catch((error) => {
        alert("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CreateBoatReservation
        createBoatReservationHandler={createBoatReservation}
      ></CreateBoatReservation>
      <Footerr></Footerr>
    </div>
  );
}
