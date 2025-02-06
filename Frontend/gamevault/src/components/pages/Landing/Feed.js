import React, { useState, useEffect } from "react";

function Feed() {
  const [reviews, setReviews] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchReviews = async () => {
      try {
        const response = await axios.get("http://localhost:8080/reviews");
        setReviews(response.data);
        setLoading(false);
      } catch (err) {
        setError(err.message);
        setLoading(false);
      }
    };

    fetchReviews();
  }, []); // Empty dependency array means this runs once on mount

  if (loading) return <div>Loading reviews...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
      <div className="review-feed">
        {reviews.map((review) => (
          <div key={review.reviewId} className="review-card">
            <h3>{review.game.title}</h3>
            <p>Score: {review.score}/10</p>
            <p>{review.comment}</p>
            <p>Played {review.hoursPlayed} hours on {review.platform}</p>
            <small>{new Date(review.data).toLocaleDateString()}</small>
          </div>
        ))}
      </div>
  );
}

export default Feed;