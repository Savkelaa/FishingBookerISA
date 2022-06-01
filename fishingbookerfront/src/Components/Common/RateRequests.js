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
  cottageRateRequests,
  cottageOwnerRateRequests,
  updateCottageRateHandler,
  updateCottageOwnerRateHandler,
  boatRateRequests,
  boatOwnerRateRequests,
  updateBoatRateHandler,
  updateBoatOwnerRateHandler,
}) {
  console.log("fishingClassRateRequests", fishingClassRateRequests);
  console.log("instructorRateRequests", instructorRateRequests);
  console.log("cottageRateRequests", cottageRateRequests);
  console.log("cottageOwnerRateRequests", cottageOwnerRateRequests);
  console.log("boatRateRequests", boatRateRequests);
  console.log("boatOwnerRateRequests", boatOwnerRateRequests);
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
      <div className="header">
        <h1 style={{ textAlign: "center" }}> Boat Rate Requests </h1>
      </div>
      {boatRateRequests.map((rateRequest) => (
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
                        Boat: {rateRequest.boat.name}{" "}
                      </Card.Title>
                      <Card.Text>Rate: {rateRequest.rate}</Card.Text>
                    </Card.Body>

                    <Card.Body>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "true";
                          rateRequest.request = "false";
                          updateBoatRateHandler(rateRequest);
                        }}
                      >
                        Accept
                      </Button>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "false";
                          rateRequest.request = "false";
                          updateBoatRateHandler(rateRequest);
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
        <h1 style={{ textAlign: "center" }}> Boat owner rate requests </h1>
      </div>
      {boatOwnerRateRequests.map((rateRequest) => (
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
                        Boat Owner: {rateRequest.boatOwner.name}{" "}
                        {rateRequest.boatOwner.surname}
                      </Card.Title>
                      <Card.Text>Rate: {rateRequest.rate}</Card.Text>
                    </Card.Body>

                    <Card.Body>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "true";
                          rateRequest.request = "false";
                          updateBoatOwnerRateHandler(rateRequest);
                        }}
                      >
                        Accept
                      </Button>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "false";
                          rateRequest.request = "false";
                          updateBoatOwnerRateHandler(rateRequest);
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
        <h1 style={{ textAlign: "center" }}> Cottage Rate Requests </h1>
      </div>
      {cottageRateRequests.map((rateRequest) => (
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
                        Cottage: {rateRequest.cottage.name}{" "}
                      </Card.Title>
                      <Card.Text>Rate: {rateRequest.rate}</Card.Text>
                    </Card.Body>

                    <Card.Body>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "true";
                          rateRequest.request = "false";
                          updateCottageRateHandler(rateRequest);
                        }}
                      >
                        Accept
                      </Button>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "false";
                          rateRequest.request = "false";
                          updateCottageRateHandler(rateRequest);
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
        <h1 style={{ textAlign: "center" }}> Cottage owner rate requests </h1>
      </div>
      {cottageOwnerRateRequests.map((rateRequest) => (
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
                        Cottage Owner: {rateRequest.cottageOwner.name}{" "}
                        {rateRequest.cottageOwner.surname}
                      </Card.Title>
                      <Card.Text>Rate: {rateRequest.rate}</Card.Text>
                    </Card.Body>

                    <Card.Body>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "true";
                          rateRequest.request = "false";
                          updateCottageOwnerRateHandler(rateRequest);
                        }}
                      >
                        Accept
                      </Button>
                      <Button
                        onClick={() => {
                          rateRequest.accepted = "false";
                          rateRequest.request = "false";
                          updateCottageOwnerRateHandler(rateRequest);
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
