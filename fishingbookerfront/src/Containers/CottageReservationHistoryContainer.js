import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import cottageQuickReservationServices from "../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import CottageReservationHistory from "../Components/Common/CottageReservationHistory";

export default function CottageReservationHistoryContainer() {
  const [finishedReservations, setFinishedReservations] = useState([]);

  var logedOwner = JSON.parse(localStorage.getItem("CottageOwner"));

  useEffect(() => {
    cottageQuickReservationServices
      .getAllCottageQuickReservationsByOwner(logedOwner.id)
      .then((data) => {
        setFinishedReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <CottageReservationHistory
        finishedReservations={finishedReservations}
      ></CottageReservationHistory>
      <Footerr></Footerr>
    </div>
  );
}
