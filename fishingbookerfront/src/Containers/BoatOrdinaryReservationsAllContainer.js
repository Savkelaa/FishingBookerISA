import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import boatQuickReservationServices from "../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import CottageReservationHistoryClientSide from "../Components/Common/BoatOrdinaryReservationsAll"

export default function CottageReservationHistoryContainer() {
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
      <CottageReservationHistoryClientSide
        finishedReservations={finishedReservations}
      ></CottageReservationHistoryClientSide>
      <Footerr></Footerr>
    </div>
  );
}
