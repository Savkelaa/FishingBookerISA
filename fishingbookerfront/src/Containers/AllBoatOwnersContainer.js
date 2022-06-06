import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import boatServices from "../Services/BoatServices/BoatServices";
import BoatOwners from "../Components/Common/BoatOwners";
import userServices from "../Services/UserServices/UserServices";
import NavbarAdmin from "../Components/Common/NavbarAdmin";

export default function AllBoatOwnersContainer() {
  const [boatOwners, setBoatOwners] = useState([]);

  useEffect(() => {
    userServices
      .getAllNotDeletedBoatOwners()

      .then((data) => {
        setBoatOwners(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function updateBoatOwner(boatOnwer) {
    userServices
      .updateBoatOwner(boatOnwer)
      .then((data) => {
        console.log("sucessfuly updated BoatOwnres owner");

        alert("sucessfuly updated BoatOwnres");
        userServices
          .getAllNotDeletedBoatOwners()
          .then((data) => {
            setBoatOwners(data.data);
          })
          .catch((error) => console.log(`error`, error));
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <NavbarAdmin></NavbarAdmin>
      <BoatOwners
        boatOwners={boatOwners}
        updateBoatOwnerHandler={updateBoatOwner}
      ></BoatOwners>
      <Footerr></Footerr>
    </div>
  );
}
