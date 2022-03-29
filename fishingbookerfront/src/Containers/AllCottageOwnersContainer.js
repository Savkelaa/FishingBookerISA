import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import userServices from "../Services/UserServices/UserServices";
import CottageOwners from "../Components/Common/CottageOwners";

export default function AllCottageOwnersContainer() {
  const [cottageOwners, setCottageOwners] = useState([]);

  useEffect(() => {
    userServices
      .getAllCottageOwners()
      .then((data) => {
        setCottageOwners(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <CottageOwners cottageOwners={cottageOwners}></CottageOwners>
      <Footerr></Footerr>
    </div>
  );
}
