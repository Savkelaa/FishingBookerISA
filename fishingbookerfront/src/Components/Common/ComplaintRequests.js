import React, { useState, useEffect, useRef } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import ComplaintAnswer from "./ComplaintAnswer";
import ComplaintAnswer2 from "./ComplaintAnswer2";
import ComplaintAnswer3 from "./ComplaintAnswer3";
import Popup from "./Popup";

export default function ComplaintRequests({
  complaintRequests,
  complaintRequests2,
  complaintRequests3,
  updateComplaintHandler,
}) {
  console.log("complaintRequests", complaintRequests);

  const answer = useRef();

  return (
    <div>
      <div className="header">
        <h1 style={{ textAlign: "center" }}>Complaint requests </h1>
      </div>
      {complaintRequests.map((complaintRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        Client who wrote complaint:<br></br>{" "}
                        {complaintRequest.client.name}{" "}
                        {complaintRequest.client.surname}
                      </Card.Title>
                      <Card.Title className="cardTitle">
                        For instructor:<br></br>{" "}
                        {complaintRequest.instructor.name}{" "}
                        {complaintRequest.instructor.surname}
                      </Card.Title>
                      <Card.Text>
                        Description of complaint: <br></br>
                        {complaintRequest.description}
                      </Card.Text>
                    </Card.Body>
                    <ComplaintAnswer
                      updateComplaintHandler={updateComplaintHandler}
                      complaintRequest={complaintRequest}
                    ></ComplaintAnswer>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
        
      ))}
          <div className="header">
        <h1 style={{ textAlign: "center" }}>Boat Complaint requests </h1>
      </div>
      {complaintRequests2.map((complaintRequest2) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        Client who wrote complaint:<br></br>{" "}
                        {complaintRequest2.client.name}{" "}
                        {complaintRequest2.client.surname}
                      </Card.Title>
                      <Card.Title className="cardTitle">
                        For owner:<br></br>{" "}
                        {complaintRequest2.boatQuickReservation.boat.boatOwner.name}{" "}
                        {complaintRequest2.boatQuickReservation.boat.boatOwner.surname}
                      </Card.Title>
                      <Card.Text>
                        Description of complaint: <br></br>
                        {complaintRequest2.description}
                      </Card.Text>
                    </Card.Body>
                    <ComplaintAnswer2
                      updateComplaintHandler={updateComplaintHandler}
                      complaintRequest2={complaintRequest2}
                    ></ComplaintAnswer2>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
        
      ))}

<div className="header">
        <h1 style={{ textAlign: "center" }}>Cottage Complaint requests </h1>
      </div>
      {complaintRequests3.map((complaintRequest3) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        Client who wrote complaint:<br></br>{" "}
                        {complaintRequest3.client.name}{" "}
                        {complaintRequest3.client.surname}
                      </Card.Title>
                      <Card.Title className="cardTitle">
                        For owner:<br></br>{" "}
                        {complaintRequest3.cottageQuickReservation.cottage.cottageOwner.name}{" "}
                        {complaintRequest3.cottageQuickReservation.cottage.cottageOwner.surname}
                      </Card.Title>
                      <Card.Text>
                        Description of complaint: <br></br>
                        {complaintRequest3.description}
                      </Card.Text>
                    </Card.Body>
                    <ComplaintAnswer3
                      updateComplaintHandler={updateComplaintHandler}
                      complaintRequest3={complaintRequest3}
                    ></ComplaintAnswer3>
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
