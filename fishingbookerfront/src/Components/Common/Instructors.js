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

export default function Instructors({ instructors, updateInstructorHandler }) {
  console.log("instructors", instructors);

  return (
    <div>
      <div className="header">
        <h1 style={{ textAlign: "center" }}> All Instructors </h1>
      </div>
      {instructors.map((instructor) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {instructor.name} {instructor.surname}
                      </Card.Title>
                      <Card.Text>{instructor.email}</Card.Text>
                      <Card.Text>Biography: {instructor.biography}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {instructor.address}, {instructor.city},{" "}
                        {instructor.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {instructor.number}
                      </ListGroupItem>
                      <ListGroupItem>
                        Rate: {instructor.averageRate}
                      </ListGroupItem>
                      <ListGroupItem>
                        Explanation of registration: {instructor.explanation}
                      </ListGroupItem>
                    </ListGroup>
                
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
