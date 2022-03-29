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

export default function Request({
  instructorRequests,
  boatOwnerRequests,
  cottageOwnerRequests,
  activateCottageOwnerHandler,
  activateBoatOwnerHandler,
  activateInstructorHandler,
  removeCottageOwnerHandler,
  removeBoatOwnerHandler,
  removeInstructorHandler,
}) {
  //const [buttonPopup, setbuttonPopup] = useState(false);
  const [instructorRequest, setinstructorRequest] = useState({});

  console.log("instructorRequests", instructorRequests);
  console.log("boatOwnerRequests", boatOwnerRequests);
  console.log("cottageOwnerRequests", cottageOwnerRequests);
  return (
    <div>
      <div className="header">
        {" "}
        <h1 style={{ textAlign: "center" }}> Instructor requests </h1>
      </div>
      {instructorRequests.map((instructorRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {instructorRequest.name} {instructorRequest.surname}
                      </Card.Title>
                      <Card.Text>{instructorRequest.email}</Card.Text>
                      <Card.Text>
                        Biography: {instructorRequest.shortBiography}
                      </Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {instructorRequest.address},{" "}
                        {instructorRequest.city}, {instructorRequest.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {instructorRequest.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration:{" "}
                        {instructorRequest.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Button
                        onClick={(e) =>
                          activateInstructorHandler(instructorRequest)
                        }
                        style={{ width: "8rem" }}
                        variant="outline-success"
                      >
                        Accept
                      </Button>

                      <Popup
                        removeInstructorHandler={removeInstructorHandler}
                        instructorRequest={instructorRequest}
                      ></Popup>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
      <div className="header">
        {" "}
        <h1 style={{ textAlign: "center" }}> Boat owner requests </h1>
      </div>
      {boatOwnerRequests.map((boatOwnerRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {boatOwnerRequest.name} {boatOwnerRequest.surname}
                      </Card.Title>
                      <Card.Text>{boatOwnerRequest.email}</Card.Text>
                      <Card.Text>
                        Biography: {boatOwnerRequest.shortBiography}
                      </Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {boatOwnerRequest.address},{" "}
                        {boatOwnerRequest.city}, {boatOwnerRequest.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {boatOwnerRequest.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration:{" "}
                        {boatOwnerRequest.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Button
                        onClick={(e) =>
                          activateBoatOwnerHandler(boatOwnerRequest)
                        }
                        style={{ width: "8rem" }}
                        variant="outline-success"
                      >
                        Accept
                      </Button>

                      <Popup
                        removeBoatOwnerHandler={removeBoatOwnerHandler}
                        boatOwnerRequest={boatOwnerRequest}
                      ></Popup>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
      <div className="header">
        {" "}
        <h1 style={{ textAlign: "center" }}> Cottage owner requests </h1>
      </div>
      {cottageOwnerRequests.map((cottageOwnerRequest) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {cottageOwnerRequest.name} {cottageOwnerRequest.surname}
                      </Card.Title>
                      <Card.Text>{cottageOwnerRequest.email}</Card.Text>
                      <Card.Text>
                        Biography: {cottageOwnerRequest.shortBiography}
                      </Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {cottageOwnerRequest.address},{" "}
                        {cottageOwnerRequest.city},{" "}
                        {cottageOwnerRequest.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {cottageOwnerRequest.number}
                      </ListGroupItem>

                      <ListGroupItem>
                        Explanation of registration:{" "}
                        {cottageOwnerRequest.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Button
                        onClick={(e) =>
                          activateCottageOwnerHandler(cottageOwnerRequest)
                        }
                        style={{ width: "8rem" }}
                        variant="outline-success"
                      >
                        Accept
                      </Button>

                      <Popup
                        removeCottageOwnerHandler={removeCottageOwnerHandler}
                        cottageOwnerRequest={cottageOwnerRequest}
                      ></Popup>
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
