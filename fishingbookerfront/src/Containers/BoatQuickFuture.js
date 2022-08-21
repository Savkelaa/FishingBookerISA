import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import boatQuickReservationServices from "../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import BoatCurrentReservations from "../Components/Common/BoatQuickFuture";

export default function BoatCurrentReservationsContainer() {
  const [currentReservations, setCurrentReservations] = useState([]);

  var logedOwner = JSON.parse(localStorage.getItem("BoatOwner"));
  var logedClient=JSON.parse(localStorage.getItem("Client"));

  useEffect(() => {
    boatQuickReservationServices
      .getAllBoatReservationsByClient(logedClient.id)
      .then((data) => {
        setCurrentReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <BoatCurrentReservations
        currentReservations={currentReservations}
      ></BoatCurrentReservations>
      <Footerr></Footerr>
    </div>
  );
}
