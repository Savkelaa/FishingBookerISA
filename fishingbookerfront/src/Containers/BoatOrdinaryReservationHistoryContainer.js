import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import boatQuickReservationServices from "../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import BoatReservationHistory from "../Components/Common/BoatOrdinaryReservationHistory";

export default function BoatReservationHistoryContainer() {
  const [finishedReservations, setFinishedReservations] = useState([]);

  var logedClient = JSON.parse(localStorage.getItem("Client"));

  useEffect(() => {
    boatQuickReservationServices
      .getAllBoatReservationsByClient2(logedClient.id)
      .then((data) => {
        setFinishedReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <BoatReservationHistory
        finishedReservations={finishedReservations}
      ></BoatReservationHistory>
      <Footerr></Footerr>
    </div>
  );
}
