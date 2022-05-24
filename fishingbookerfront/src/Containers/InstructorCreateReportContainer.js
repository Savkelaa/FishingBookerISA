import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import reportServices from "../Services/ReportServices/ReportServices";
import { useParams } from "react-router-dom";
import InstructorCreateReport from "../Components/Common/InstructorCreateReport";

function InstructorCreateReportContainer() {
  const [instructorReports, setInstructorReports] = useState([]);

  function addInstructorReport(instructorReport) {
    reportServices
      .createInstructorReport(instructorReport)
      .then((data) => {
        if (data.status === 204) setInstructorReports([]);
        else {
          setInstructorReports(data.data.content);
          console.log("sucessfuly added a instructor report .");
          console.log("instructorReport", instructorReport);
        }
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
      ></InstructorCreateReport>
      <Footerr></Footerr>
    </div>
  );
}

export default InstructorCreateReportContainer;
