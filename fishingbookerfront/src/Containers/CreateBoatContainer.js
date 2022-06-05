import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import BoatServices from "../Services/BoatServices/BoatServices";
import CreateBoatForm from "../Components/Common/CreateBoatForm";

export default function CreateBoatContainer() {
  const [boat, setBoat] = useState();

  function createBoat(boat) {
    BoatServices.addBoat(boat)
      .then((data) => {
        if (data.status === 204) setBoat();
        else {
          setBoat(data.data);
          alert("sucessfuly added a boat");
        }
      })
      .catch((error) => {
        alert("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CreateBoatForm
        createBoatHandler={createBoat}
      ></CreateBoatForm>
      <Footerr></Footerr>
    </div>
  );
}
