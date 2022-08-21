import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import boatQuickReservationServices from "../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import fishingClassService from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices"
import CottageReservationHistoryClientSide from "../Components/Common/FishingClassOrdinaryReservationsAll"

export default function CottageReservationHistoryContainer() {
  const [finishedReservations, setFinishedReservations] = useState([]);

  var logedClient = JSON.parse(localStorage.getItem("Client"));

  useEffect(() => {
    fishingClassService
    .getAllFishingClassReservations2ByClient(logedClient.id)
      .then((data) => {
        setFinishedReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

 
  return (
    <div>
      <Navbarr></Navbarr>
      <CottageReservationHistoryClientSide
        finishedReservations={finishedReservations}
      ></CottageReservationHistoryClientSide>
      <Footerr></Footerr>
    </div>
  );
}
