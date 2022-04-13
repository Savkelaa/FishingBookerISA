import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import FishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import FishingClassServices from "../Services/FishingClassServices/FishingClassServices";
import FishingClassesForm from "../Components/Common/FishingClassesForm";

export default function CreateFishingClass() {
  const [fishingClass, setFishingClass] = useState();

  function createFishingClass(fishingClass) {
    FishingClassServices.createFishingClass(fishingClass)
      .then((data) => {
        if (data.status === 204) setFishingClass();
        else {
          setFishingClass(data.data);
          console.log("sucessfuly added a fishingClass");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <FishingClassesForm
        createFishingClassHandler={createFishingClass}
      ></FishingClassesForm>
      <Footerr></Footerr>
    </div>
  );
}
