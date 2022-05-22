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

export default function RateRequests({
  fishingClassRateRequests,
  instructorRateRequests,
  updateFishingClassRateHandler,
  updateInstructorRateHandler,
}) {
  console.log("fishingClassRateRequests", fishingClassRateRequests);
  console.log("instructorRateRequests", instructorRateRequests);
  return (
    <div>
      <div className="header">
        <h1 style={{ textAlign: "center" }}> Fishing Class Rate Requests </h1>
      </div>
      {fishingClassRateRequests.map((rateRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        Client: {rateRequest.client.name}{" "}
                        {rateRequest.client.surname}
                      </Card.Title>
                      <Card.Title className="cardTitle">
                        Fishing Class: {rateRequest.fishingClass.name}{" "}
                      </Card.Title>
                      <Card.Text>Rate: {rateRequest.rate}</Card.Text>
                    </Card.Body>

                    <Card.Body>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "true";
                          rateRequest.request = "false";
                          updateFishingClassRateHandler(rateRequest);
                        }}
                      >
                        Accept
                      </Button>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "false";
                          rateRequest.request = "false";
                          updateFishingClassRateHandler(rateRequest);
                        }}
                        className="btn btn-danger"
                      >
                        Reject
                      </Button>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
      <div className="header">
        <h1 style={{ textAlign: "center" }}> Instructor rate requests </h1>
      </div>
      {instructorRateRequests.map((rateRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        Client: {rateRequest.client.name}{" "}
                        {rateRequest.client.surname}
                      </Card.Title>
                      <Card.Title className="cardTitle">
                        Instructor: {rateRequest.instructor.name}{" "}
                        {rateRequest.instructor.surname}
                      </Card.Title>
                      <Card.Text>Rate: {rateRequest.rate}</Card.Text>
                    </Card.Body>

                    <Card.Body>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "true";
                          rateRequest.request = "false";
                          updateInstructorRateHandler(rateRequest);
                        }}
                      >
                        Accept
                      </Button>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "false";
                          rateRequest.request = "false";
                          updateInstructorRateHandler(rateRequest);
                        }}
                        className="btn btn-danger"
                      >
                        Reject
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
