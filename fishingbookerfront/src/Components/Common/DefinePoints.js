import React, { useRef } from "react";
import { ListGroup, Image } from "react-bootstrap";

import "../../App.css";
import { BrowserRouter as Link } from "react-router-dom";
import slika from "../../Assets/img/slika1.jpg";

export default function DefinePoints({
  updatePointsHandler,
  reservationPoints,
}) {
  const points = useRef();
  const ownerPoints = useRef();

  console.log("reservationPoints", reservationPoints);
  return (
    <div className="container">
      <div className="row gutters">
        <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
          <div className="card h-100">
            <div className="card-body">
              <div className="row gutters">
                <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                  <h5 className="mb-2 text-primary">Fishing Class Details</h5>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="fullName">Points</h6>
                    <input
                      ref={points}
                      type="text"
                      className="form-control"
                      id="fullName"
                    />
                  </div>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="fullName">Owner points</h6>
                    <input
                      ref={ownerPoints}
                      type="text"
                      className="form-control"
                      id="fullName"
                    />
                  </div>
                </div>

                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div className="text-right">
                      <button
                        type="button"
                        id="submit"
                        name="submit"
                        className="btn btn-secondary"
                        onClick={() => {
                          reservationPoints.points = points.current.value;
                          reservationPoints.ownerPoints =
                            ownerPoints.current.value;
                          updatePointsHandler(reservationPoints);
                        }}
                      >
                        Update
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
