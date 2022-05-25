import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";

import RateRequests from "../Components/Common/ReportRequests";
import reportServices from "../Services/ReportServices/ReportServices";
import ReportRequests from "../Components/Common/ReportRequests";
import userServices from "../Services/UserServices/UserServices";

export default function ReportRequestsContainer() {
  const [badReports, setBadReports] = useState([]);

  useEffect(() => {
    reportServices
      .getAllInstructorBadReports()

      .then((data) => {
        setBadReports(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

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

  function updateInstructorReport(report) {
    console.log("rate", report);
    reportServices
      .updateInstructorReport(report)

      .then((data) => {
        if (data.status === 204) setBadReports([]);
        else {
          reportServices
            .getAllInstructorBadReports()
            .then((data) => {
              setBadReports(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a instructor requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <ReportRequests
        badReports={badReports}
        updateClientHandler={updateClient}
        updateInstructorReportHandler={updateInstructorReport}
      ></ReportRequests>
      <Footerr></Footerr>
    </div>
  );
}
