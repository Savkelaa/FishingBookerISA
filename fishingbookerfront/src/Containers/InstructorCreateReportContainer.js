import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import reportServices from "../Services/ReportServices/ReportServices";
import { useParams } from "react-router-dom";
import InstructorCreateReport from "../Components/Common/InstructorCreateReport";
import userServices from "../Services/UserServices/UserServices";

function InstructorCreateReportContainer() {
  const [instructorReports, setInstructorReports] = useState([]);
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

  function addInstructorReport(instructorReport) {
    reportServices
      .createInstructorReport(instructorReport)
      .then((data) => {
        if (data.status === 204) setInstructorReports([]);
        else {
          setInstructorReports(data.data.content);
          console.log("sucessfuly added a instructor report .");
          console.log("instructorReport", instructorReport);
          alert("sucessfuly added a instructor report .");
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
        alert("sucessfuly updated a client ");

        console.log("client", client);
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <InstructorCreateReport
        addInstructorReportHandler={addInstructorReport}
        updateClientHandler={updateClient}
        client={client}
      ></InstructorCreateReport>
      <Footerr></Footerr>
    </div>
  );
}

export default InstructorCreateReportContainer;
