import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";

import rateServices from "../Services/RateServices/RateServices";
import RateRequests from "../Components/Common/RateRequests";
import userServices from "../Services/UserServices/UserServices";
import DefinePoints from "../Components/Common/DefinePoints";

export default function DefinePointsContainer() {
  const [points, setPoints] = useState([]);

  useEffect(() => {
    userServices
      .getReservationPoints(1)
      .then((data) => {
        setPoints(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function updatePoints(points) {
    userServices
      .updateReservationPoints(points)
      .then((data) => {
        if (data.status === 204) setPoints([]);
        else {
          userServices
            .updateReservationPoints(points)
            .then((data) => {
              setPoints(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a points");
          alert("sucessfuly updated a points");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <DefinePoints
        updatePointsHandler={updatePoints}
        reservationPoints={points}
      ></DefinePoints>
      <Footerr></Footerr>
    </div>
  );
}
