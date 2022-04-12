import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import FishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";

export default function CreateFishingClassReservationContainer() {
  const [quickReservation, setQuickReservation] = useState();

  function createFishingClassQuickReservation(quickReservation) {
    FishingClassQuickReservationServices.createFishingClassQuickReservation(
      quickReservation
    )
      .then((data) => {
        if (data.status === 204) setQuickReservation();
        else {
          setQuickReservation(data.data);
          console.log("sucessfuly added a quickReservation");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <QuickReservationForm
        createFishingClassQuickReservationHandler={createFishingClassQuickReservation}
      ></QuickReservationForm>
      <Footerr></Footerr>
    </div>
  );
}
