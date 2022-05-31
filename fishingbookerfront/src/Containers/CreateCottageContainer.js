import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import CottageServices from "../Services/CottageServices/CottageServices";
import CreateCottageForm from "../Components/Common/CreateCottageForm";

export default function CreateCottage() {
  const [cottage, setCottage] = useState();

  function createCottage(cottage) {
    CottageServices.addCottage(cottage)
      .then((data) => {
        if (data.status === 204) setCottage();
        else {
          setCottage(data.data);
          alert("sucessfuly added a cottage");
        }
      })
      .catch((error) => {
        alert("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CreateCottageForm
        createCottageHandler={createCottage}
      ></CreateCottageForm>
      <Footerr></Footerr>
    </div>
  );
}
