import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import cottageQuickReservationServices from "../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import CottageReservationHistory from "../Components/Common/CottageReservationHistory";
import CottageReservationHistoryClientSide from "../Components/Common/CottageReservationClientAll"

export default function CottageReservationHistoryContainer() {
  const [finishedReservations, setFinishedReservations] = useState([]);

  var logedClient = JSON.parse(localStorage.getItem("Client"));

  useEffect(() => {
    cottageQuickReservationServices
    .getAllCottageQuickReservationByClient(logedClient.id)
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
