import React, { useState, useEffect } from "react";
import CurrentReservations from "../Components/Common/CurrentReservations";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import FishingClassFutureReservationClient from "../Components/Common/FishingClassFutureReservationClient";

export default function FishingClassFutureReservationClientContainer() {
  const [futureReservations, setFutureReservations] = useState([]);

  useEffect(() => {
    fishingClassQuickReservationServices
      .getAllFishingClassReservationsByClient(1)
      .then((data) => {
        setFutureReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <FishingClassFutureReservationClient
        futureReservations={futureReservations}
      ></FishingClassFutureReservationClient>
      <Footerr></Footerr>
    </div>
  );
}
