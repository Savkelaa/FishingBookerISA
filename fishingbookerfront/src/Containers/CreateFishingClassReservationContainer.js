import React from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import background from "../Assets/img/background.jpg";
import QuickReservationForm from "../Components/Common/QuickReservationForm";

export default function CreateFishingClassReservationContainer() {
  return (
    <div
      style={{
        backgroundImage: `url(${background})`,
        backgroundPosition: "center",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
      }}
    >
      <Navbarr></Navbarr>
      <QuickReservationForm></QuickReservationForm>
      <Footerr></Footerr>
    </div>
  );
}
