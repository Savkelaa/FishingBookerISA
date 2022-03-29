import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import boatServices from "../Services/BoatServices/BoatServices";
import BoatOwners from "../Components/Common/BoatOwners";
import userServices from "../Services/UserServices/UserServices";

export default function AllBoatOwnersContainer() {
  const [boatOwners, setBoatOwners] = useState([]);

  useEffect(() => {
    userServices
      .getAllBoatOwners()

      .then((data) => {
        setBoatOwners(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <BoatOwners boatOwners={boatOwners}></BoatOwners>
      <Footerr></Footerr>
    </div>
  );
}
