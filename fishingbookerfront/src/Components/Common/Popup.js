import React, { useRef, useState } from "react";

function Popup({
  removeInstructorHandler,
  instructorRequest,
  trigger,
  setTrigger,
}) {
  const [refusalReason, setRefusalReason] = useState("");
  const reason = useRef();

  instructorRequest.refusalReason = refusalReason;

  return trigger ? (
    <div className="popup">
      <div className="popup-inner">
        <h6 for="text">To remove you need to enter Refusal Reason: </h6>
        <input
          ref={reason}
          type="refusalReason"
          className="form-control"
          id="refusalReason"
        />
        <button
          className="btn btn-danger"
          onClick={(e) => {
            instructorRequest.refusalReason = reason.current.value;
            removeInstructorHandler(instructorRequest);
          }}
        >
          Remove
        </button>
      </div>
    </div>
  ) : (
    ""
  );
}

export default Popup;
