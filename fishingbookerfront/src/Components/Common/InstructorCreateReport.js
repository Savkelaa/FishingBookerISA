import React, { useRef, useState } from "react";
import { useHistory } from "react-router-dom";
import { useParams } from "react-router-dom";

export default function InstructorCreateReport({ addInstructorReportHandler }) {
  const [badd, setBadd] = useState("");
  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));
  let { id } = useParams();

  const description = useRef();
  const bad = useRef();
  const bad1 = useRef();

  function saveHandler(e) {
    addInstructorReportHandler({
      description: description.current.value,
      bad: badd,
      client: {
        id: id,
      },
      instructor: { id: logedInstructor.id },
    });
  }

  return (
    <form action="javascript:void(0);" onSubmit={saveHandler}>
      <div className="container">
        <div className="row gutters">
          <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <div className="card h-100">
              <div className="card-body">
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h5 className="mb-2 text-primary">
                      Create report for client
                    </h5>
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="website">Description</h6>
                    <input
                      ref={description}
                      type="text"
                      className="form-control"
                      id="place"
                    />
                  </div>
                  <div className="radio-btn-container">
                    <div
                      className="radio-btn"
                      onClick={() => {
                        setBadd("true");
                      }}
                    >
                      <input
                        type="radio"
                        value={badd}
                        name="badd"
                        checked={badd == "true"}
                      />
                      Yes
                    </div>
                    <div
                      className="radio-btn"
                      onClick={() => {
                        setBadd("false");
                      }}
                    >
                      <input
                        type="radio"
                        value={badd}
                        name="badd"
                        checked={badd == "false"}
                      />
                      No
                    </div>
                  </div>
                </div>
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div className="text-right">
                      <button
                        type="submit"
                        id="submit"
                        name="submit"
                        className="btn btn-success"
                      >
                        Create
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  );
}
