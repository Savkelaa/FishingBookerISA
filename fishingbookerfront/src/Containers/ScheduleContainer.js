import React from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import Schedule from "../Components/Common/Schedule";

export default function ScheduleContainer() {
  return (
    <div>
      <Navbarr></Navbarr>
      <Schedule></Schedule>
      <Footerr></Footerr>
    </div>
  );
}
