import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import FishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import CreateFishingClassReservation from "../Components/Common/CreateFishingClassReservation";

export default function CreateFishingClassReservationContainer() {
  const [reservation, setReservation] = useState();

  function createFishingClassReservation(reservation) {
    FishingClassQuickReservationServices.createFishingClassReservation(
      reservation
    )
      .then((data) => {
        if (data.status === 204) setReservation();
        else {
          setReservation(data.data);
          console.log("sucessfuly added a reservation");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CreateFishingClassReservation
        createFishingClassReservationHandler={createFishingClassReservation}
      ></CreateFishingClassReservation>
      <Footerr></Footerr>
    </div>
  );
}
