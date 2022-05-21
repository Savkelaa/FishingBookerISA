import React, { useState, useEffect } from "react";
import CurrentReservations from "../Components/Common/CurrentReservations";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import FishingClassReservationHistory from "../Components/Common/FishingClassReservationHistory";
import FishingClassReservationHistoryByClient from "../Components/Common/FishingClassReservationHistoryByClient";

export default function FishingClassReservationHistoryByClientContainer() {
  const [reservationHistory, setReservationHistory] = useState([]);

  useEffect(() => {
    fishingClassQuickReservationServices
      .getAllFishingClassReservationsByClient(1)
      .then((data) => {
        setReservationHistory(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <FishingClassReservationHistoryByClient
        reservationHistory={reservationHistory}
      ></FishingClassReservationHistoryByClient>
      <Footerr></Footerr>
    </div>
  );
}
