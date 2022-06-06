import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import userServices from "../Services/UserServices/UserServices";
import CottageOwners from "../Components/Common/CottageOwners";

export default function AllCottageOwnersContainer() {
  const [cottageOwners, setCottageOwners] = useState([]);

  useEffect(() => {
    userServices
      .getAllNotDeletedCottageOwners()
      .then((data) => {
        setCottageOwners(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function updateCottageOwner(cottageOwner) {
    userServices
      .updateCottageOwner(cottageOwner)
      .then((data) => {
        console.log("sucessfuly updated Cottage owner");
        console.log("INSTRUCTORRRR", cottageOwner);

        alert("sucessfuly updated cottageOwner");
        userServices
          .getAllNotDeletedCottageOwners()
          .then((data) => {
            setCottageOwners(data.data);
          })
          .catch((error) => console.log(`error`, error));
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CottageOwners
        cottageOwners={cottageOwners}
        updateCottageOwnerHandler={updateCottageOwner}
      ></CottageOwners>
      <Footerr></Footerr>
    </div>
  );
}
