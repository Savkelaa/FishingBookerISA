import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import reportServices from "../Services/ReportServices/ReportServices";
import { useParams } from "react-router-dom";
import BoatOwnerCreateReport from "../Components/Common/BoatOwnerCreateReport";
import userServices from "../Services/UserServices/UserServices";

function BoatOwnerCreateReportContainer() {
  const [boatOwnerReports, setBoatOwnerReports] = useState([]);
  const [client, setClient] = useState([]);
  let { id } = useParams();

  useEffect(() => {
    userServices
      .getClientsById(id)
      .then((data) => {
        console.log("data.data", data.data);
        setClient(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function addBoatOwnerReport(boatOwnerReport) {
    reportServices
      .createBoatOwnerReport(boatOwnerReport)
      .then((data) => {
        if (data.status === 204) setBoatOwnerReports([]);
        else {
          setBoatOwnerReports(data.data.content);
          alert("sucessfuly added a boatOwner report .");
          console.log("boatOwnerReport", boatOwnerReport);
        }
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  function updateClient(client) {
    console.log("client", client);
    userServices
      .updateClient(client)
      .then((data) => {
        console.log("sucessfuly updated a client ");
        console.log("client", client);
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <BoatOwnerCreateReport
        addBoatOwnerReportHandler={addBoatOwnerReport}
        updateClientHandler={updateClient}
        client={client}
      ></BoatOwnerCreateReport>
      <Footerr></Footerr>
    </div>
  );
}

export default BoatOwnerCreateReportContainer;
