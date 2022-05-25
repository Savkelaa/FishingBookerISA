import React, { useState, useEffect } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import Popup from "./Popup";

export default function ReportRequests({
  badReports,
  updateClientHandler,
  updateInstructorReportHandler,
}) {
  console.log("badReports", badReports);

  return (
    <div>
      <div className="header">
        <h1 style={{ textAlign: "center" }}>
          {" "}
          Instructor reports for clients{" "}
        </h1>
      </div>
      {badReports.map((badReport) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        Instructor {badReport.instructor.name}{" "}
                        {badReport.instructor.surname} wrote a bad complaint for
                        the client {badReport.client.name}{" "}
                        {badReport.client.surname}.
                      </Card.Title>
                      <Card.Title className="cardTitle">
                        Description of report: {badReport.description}
                      </Card.Title>
                      <Card.Text>
                        Penalties for {badReport.client.name}{" "}
                        {badReport.client.surname}: {badReport.client.penalty}
                      </Card.Text>
                    </Card.Body>

                    <Card.Body>
                      <Button
                        onClick={() => {
                          badReport.bad = "false";
                          updateInstructorReportHandler(badReport);
                          badReport.client.penalty =
                            badReport.client.penalty + 1;
                          updateClientHandler(badReport);
                        }}
                      >
                        Give client 1 more penalty
                      </Button>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}
