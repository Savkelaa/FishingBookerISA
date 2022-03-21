import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import userServices from "../Services/UserServices/UserServices";

export default function RequestsContainer() {
  const [instructorRequests, setInstructorRequests] = useState({});
  const [boatOwnerRequests, setBoatOwnerRequests] = useState([]);
  const [cottageOwnerRequest, setCottageOwnerRequest] = useState([]);

  useEffect(() => {
    userServices
      .getAllInstructorRequests()
      .then((data) => {
        setInstructorRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllBoatOwnerRequests()
      .then((data) => {
        setBoatOwnerRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllBoatOwnerRequests()
      .then((data) => {
        setCottageOwnerRequest(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <Request
        instructorRequests={instructorRequests}
        boatOwnerRequests={boatOwnerRequests}
        cottageOwnerRequest={cottageOwnerRequest}
      ></Request>
      <Footerr></Footerr>
    </div>
  );
}
