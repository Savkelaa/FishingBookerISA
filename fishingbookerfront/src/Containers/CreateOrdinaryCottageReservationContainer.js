import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import CottageServices from "../Services/CottageServices/CottageServices";
import CreateCottageForm from "../Components/Common/DatesForCottageOrdinary";

export default function CreateCottage() {
  



  return (
    <div>
      <Navbarr></Navbarr>
      <CreateCottageForm
        
      ></CreateCottageForm>
      <Footerr></Footerr>
    </div>
  );
}
