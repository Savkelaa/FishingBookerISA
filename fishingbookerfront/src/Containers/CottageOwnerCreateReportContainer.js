import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import reportServices from "../Services/ReportServices/ReportServices";
import { useParams } from "react-router-dom";
import CottageOwnerCreateReport from "../Components/Common/CottageOwnerCreateReport";
import userServices from "../Services/UserServices/UserServices";

function CottageOwnerCreateReportContainer() {
  const [cottageOwnerReports, setCottageOwnerReports] = useState([]);
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

  function addCottageOwnerReport(cottageOwnerReport) {
    reportServices
      .createCottageOwnerReport(cottageOwnerReport)
      .then((data) => {
        if (data.status === 204) setCottageOwnerReports([]);
        else {
          setCottageOwnerReports(data.data.content);
          console.log("sucessfuly added a cottageOwner report .");
          console.log("cottageOwnerReport", cottageOwnerReport);
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
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
      <CottageOwnerCreateReport
        addCottageOwnerReportHandler={addCottageOwnerReport}
        updateClientHandler={updateClient}
        client={client}
      ></CottageOwnerCreateReport>
      <Footerr></Footerr>
    </div>
  );
}

export default CottageOwnerCreateReportContainer;
