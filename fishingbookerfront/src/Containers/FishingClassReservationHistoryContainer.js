import React, { useState, useEffect } from "react";
import CurrentReservations from "../Components/Common/CurrentReservations";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import FishingClassReservationHistory from "../Components/Common/FishingClassReservationHistory";

export default function FishingClassReservationHistoryContainer() {
  const [currentReservations, setCurrentReservations] = useState([]);

  useEffect(() => {
    fishingClassQuickReservationServices
      .getAllFishingClassReservationsByInstructor(1)
      .then((data) => {
        setCurrentReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <FishingClassReservationHistory
        currentReservations={currentReservations}
      ></FishingClassReservationHistory>
      <Footerr></Footerr>
    </div>
  );
}
