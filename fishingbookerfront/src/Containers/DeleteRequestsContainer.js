import React, { useState, useEffect } from "react";
import DeleteRequests from "../Components/Common/DeleteRequests";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import userServices from "../Services/UserServices/UserServices";

export default function DeleteRequestsContainer() {
  const [instructorDeleteRequests, setInstructorDeleteRequests] = useState([]);
  const [boatOwnerDeleteRequests, setBoatOwnerDeleteRequests] = useState([]);
  const [cottageOwnerDeleteRequests, setCottageOwnerDeleteRequests] = useState(
    []
  );
  const [adminDeleteRequests, setAdminDeleteRequests] = useState([]);
  const [clientDeleteRequests, setClientDeleteClient] = useState([]);

  useEffect(() => {
    userServices
      .getAllInstructorDeleteRequests()
      .then((data) => {
        setInstructorDeleteRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllBoatOwnerDeleteRequests()
      .then((data) => {
        setBoatOwnerDeleteRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllCottageOwnerDeleteRequests()
      .then((data) => {
        setCottageOwnerDeleteRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllAdminDeleteRequests()
      .then((data) => {
        setAdminDeleteRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllClientDeleteRequests()
      .then((data) => {
        setClientDeleteClient(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <DeleteRequests
        instructorDeleteRequests={instructorDeleteRequests}
        boatOwnerDeleteRequests={boatOwnerDeleteRequests}
        cottageOwnerDeleteRequests={cottageOwnerDeleteRequests}
        adminDeleteRequests={adminDeleteRequests}
        clientDeleteRequests={clientDeleteRequests}
      ></DeleteRequests>
      <Footerr></Footerr>
    </div>
  );
}
