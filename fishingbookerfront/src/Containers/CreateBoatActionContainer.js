import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import BoatQuickReservationServices from "../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import BoatActionForm from "../Components/Common/BoatActionForm";

export default function CreateBoatActionContainer() {
  const [quickReservation, setQuickReservation] = useState();

  function createBoatQuickReservation(boatAction) {
    BoatQuickReservationServices.createBoatQuickReservationAction(
      boatAction
    )
      .then((data) => {
        if (data.status === 204) setQuickReservation();
        else {
          setQuickReservation(data.data);
          alert("sucessfuly added a quick Reservation action");
        }
      })
      .catch((error) => {
        alert("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <BoatActionForm
        createBoatQuickReservationHandler={
          createBoatQuickReservation
        }
      ></BoatActionForm>
      <Footerr></Footerr>
    </div>
  );
}
