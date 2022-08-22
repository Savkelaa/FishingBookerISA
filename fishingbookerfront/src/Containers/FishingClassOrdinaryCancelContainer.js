import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import FishingClassReservationHistory from "../Components/Common/FishingClassOrdinaryCancel";

export default function FishingClassReservationHistoryContainer() {
  const [currentReservations, setCurrentReservations] = useState([]);

  var logedClient = JSON.parse(localStorage.getItem("Client"));

  useEffect(() => {
    fishingClassQuickReservationServices
      .getAllFishingClassReservations2ByClient(logedClient.id)
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
