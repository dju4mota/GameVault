import styled from '@emotion/styled';
import React from 'react';

const StarRatingContainer = styled.div`
  display: inline-block;
  border: 0;
  margin-left: 10px;

  .rate {
    display: inline-block;
    border: 0;
  }

  input {
    display: none;
  }

  label {
    float: right;
    position: relative;
    cursor: pointer;

    &:before {
      display: inline-block;
      font-size: 2rem;
      padding: 0.3rem 0.2rem;
      margin: 0;
      font-family: FontAwesome;
      content: "\\f005"; /* full star */
    }
  }

  .half:before {
    content: "\\f089"; /* half star no outline */
    position: absolute;
    padding-right: 0;
  }

  input:checked ~ label,
  label:hover,
  label:hover ~ label {
    color: #ff4800;
  }

  input:checked + label:hover,
  input:checked ~ label:hover,
  input:checked ~ label:hover ~ label,
  label:hover ~ input:checked ~ label {
    color: #ff4800;
  }
`;

function StarRating({ value, onChange }) {
    const ratings = [5, 4.5, 4, 3.5, 3, 2.5, 2, 1.5, 1, 0.5];
  
    const handleChange = (rating) => {
      // Simulate an event object
      const event = {
        target: {
          name: "nota",  // Matches the state key in the parent
          value: rating.toString()  // Ensure value is a string
        },
      };
      onChange(event);  // Pass the synthetic event to parent
    };
  
    return (
      <StarRatingContainer>
        <div className="rate">
          {ratings.map((rating) => {
            const isHalf = rating % 1 !== 0;  // Check for half-star
            return (
              <React.Fragment key={rating}>
                <input
                  type="radio"
                  id={`star${rating}`}
                  name="nota"  // Correct name attribute
                  value={rating}
                  checked={value === rating.toString()}  // Compare as strings
                  onChange={() => handleChange(rating)}
                />
                <label
                  htmlFor={`star${rating}`}
                  className={isHalf ? "half" : ""}  // Apply half-star style
                  title={`${rating} stars`}
                />
              </React.Fragment>
            );
          })}
        </div>
      </StarRatingContainer>
    );
  }

export default StarRating;